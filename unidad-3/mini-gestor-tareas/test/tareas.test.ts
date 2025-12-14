import { ServicioTareas } from '../src/servicioTareas';
import { RepositorioTareasSqlite } from '../src/repositorioTareasSqlite';
import { getDb } from '../src/db';

describe('Pruebas del Sistema de Tareas', () => {
    let servicio: ServicioTareas;
    let db = getDb();
    beforeEach(() => {
        RepositorioTareasSqlite.deleteAll();
        servicio = new ServicioTareas();
    });

    afterAll(() => {
        db.close();
    });

    test('Debe crear una tarea en local correctamente', async () => {
        const tarea = await servicio.crear({
            titulo: 'Test Local',
            descripcion: 'Descripcion test',
            completada: false
        }, 'local');

        expect(tarea.id).toBeDefined();
        expect(tarea.titulo).toBe('Test Local');

        const guardada = await servicio.obtenerPorId(tarea.id, 'local');
        expect(guardada).toBeDefined();
        expect(guardada?.titulo).toBe('Test Local');
    });

    test('Debe actualizar una tarea local', async () => {
        const tarea = await servicio.crear({
            titulo: 'Original',
            completada: false
        }, 'local');

        await servicio.actualizar(tarea.id, {
            titulo: 'Modificado', completada: true,
            id: 0
        }, 'local');

        const actualizada = await servicio.obtenerPorId(tarea.id, 'local');
        expect(actualizada?.titulo).toBe('Modificado');
        expect(actualizada?.completada).toBe(true);
    });

    test('Debe borrar una tarea local', async () => {
        const tarea = await servicio.crear({ titulo: 'A borrar', completada: false }, 'local');

        await servicio.borrar(tarea.id, 'local');

        const buscada = await servicio.obtenerPorId(tarea.id, 'local');
        expect(buscada).toBeUndefined();
    });
});