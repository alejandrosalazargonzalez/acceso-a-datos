// src/repositorioTareasRemoto.ts
import { Tarea, IdTarea } from "./models";
import * as api from "./apiTareas";

export class RepositorioTareasRemoto {

    async obtenerTodas(): Promise<Tarea[]> {
        return await api.obtenerTareas();
    }

    async obtenerPorId(id: IdTarea): Promise<Tarea | undefined> {
        try {
            return await api.obtenerTarea(id);
        } catch (error) {
            console.error("Error al obtener tarea remota:", error);
            return undefined;
        }
    }

    async crear(titulo: string, descripcion?: string): Promise<Tarea> {
        return await api.crearTareaRemota({
            titulo,
            descripcion,
            completada: false
        });
    }

    async actualizar(tarea: Tarea): Promise<Tarea> {
        return await api.actualizarTareaRemota(tarea);
    }

    async borrar(id: IdTarea): Promise<boolean> {
        try {
            await api.borrarTareaRemota(id);
            return true;
        } catch (error) {
            return false;
        }
    }
}