import { Tarea } from './models';

const BASE_URL = 'http://localhost:3000/tareas';

export const apiTareasRemota = {
    getAll: async (): Promise<Tarea[]> => {
        const response = await fetch(BASE_URL);
        if (!response.ok) throw new Error('Error al obtener tareas remotas');
        return await response.json() as Tarea[];
    },

    getById: async (id: number): Promise<Tarea | undefined> => {
        const response = await fetch(`${BASE_URL}/${id}`);
        if (response.status === 404) return undefined;
        if (!response.ok) throw new Error('Error al obtener tarea remota');
        return await response.json() as Tarea;
    },

    create: async (tarea: Omit<Tarea, 'id'>): Promise<Tarea> => {
        const response = await fetch(BASE_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(tarea)
        });
        if (!response.ok) {
            throw new Error(`Error del servidor: ${response.status} ${response.statusText} al acceder a ${BASE_URL}`);
        }        return await response.json() as Tarea;
    },

    update: async (id: number, tarea: Partial<Omit<Tarea, 'id'>>): Promise<Tarea> => {
        const response = await fetch(`${BASE_URL}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(tarea)
        });
        if (!response.ok) throw new Error('Error al actualizar tarea remota');
        return await response.json() as Tarea;
    },

    delete: async (id: number): Promise<void> => {
        const response = await fetch(`${BASE_URL}/${id}`, {
            method: 'DELETE'
        });
        if (!response.ok) throw new Error('Error al borrar tarea remota');
    }
};