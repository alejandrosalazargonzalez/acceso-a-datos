export interface Tarea {
    id: number | string;
    titulo: string;
    descripcion?: string;
    completada: boolean;
}

export type IdTarea = number | string;

export type FiltroTarea = 'todas' | 'pendientes' | 'completadas';

export type Origen = 'local' | 'remoto';