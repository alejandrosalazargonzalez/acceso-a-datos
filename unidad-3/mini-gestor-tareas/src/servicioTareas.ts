import { Tarea, Origen, FiltroTarea, IdTarea } from './models';
import { RepositorioTareasSqlite } from './repositorioTareasSqlite';
import { apiTareasRemota } from './apiTareasRemota';

export class ServicioTareas {

    private localRepo = new RepositorioTareasSqlite();
    private remoteApi = apiTareasRemota;

    async listar(origen: Origen, filtro: FiltroTarea = 'todas'): Promise<Tarea[]> {
        let tareas: Tarea[] = [];

        if (origen === 'local') {
            tareas = this.localRepo.obtenerTodas();
        } else {
            tareas = await this.remoteApi.getAll();
        }

        if (filtro === 'pendientes') {
            return tareas.filter(t => !t.completada);
        } else if (filtro === 'completadas') {
            return tareas.filter(t => t.completada);
        }

        return tareas;
    }

    async obtenerPorId(id: IdTarea, origen: Origen): Promise<Tarea | undefined> {
        if (origen === 'local') {
            return this.localRepo.obtenerPorId(id);
        } else {
            const idNum = Number(id);
            return await this.remoteApi.getById(isNaN(idNum) ? id as any : idNum);
        }
    }

    async crear(tarea: Omit<Tarea, 'id'>, origen: Origen): Promise<Tarea> {
        if (origen === 'local') {
            return this.localRepo.crear(tarea.titulo, tarea.descripcion);
        } else {
            return await this.remoteApi.create(tarea);
        }
    }

    async actualizar(id: IdTarea, tarea: Tarea, origen: Origen): Promise<any> {
        if (origen === 'local') {
            return this.localRepo.actualizar({ ...tarea, id });
        } else {
            const idNum = Number(id);
            return await this.remoteApi.update(isNaN(idNum) ? id as any : idNum, tarea);
        }
    }

    async borrar(id: IdTarea, origen: Origen): Promise<void> {
        if (origen === 'local') {
            this.localRepo.borrar(id);
        } else {
            const idNum = Number(id);
            await this.remoteApi.delete(isNaN(idNum) ? id as any : idNum);
        }
    }

    async sincronizarRemotoALocal(): Promise<void> {
        console.log("Iniciando sincronización...");
        try {
            const tareasRemotas = await this.remoteApi.getAll();
            if (tareasRemotas.length === 0) {
                console.log("No hay tareas remotas o no se pudo conectar.");
                return;
            }

            this.localRepo.borrarTodas();
            tareasRemotas.forEach(tarea => {
                this.localRepo.guardar(tarea);
            });
            console.log(`Sincronizadas ${tareasRemotas.length} tareas.`);
        } catch (e) {
            console.error("Error durante la sincronización", e);
        }
    }
}