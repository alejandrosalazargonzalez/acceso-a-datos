import { getDb } from "./db";
import { Tarea, IdTarea } from "./models";

export class RepositorioTareasSqlite {

    private db = getDb();

    obtenerTodas(): Tarea[] {
        const stmt = this.db.prepare("SELECT id, titulo, descripcion, completada FROM tareas");
        const rows = stmt.all() as any[];
        return rows.map(row => ({
            ...row,
            completada: Boolean(row.completada)
        }));
    }

    obtenerPorId(id: IdTarea): Tarea | undefined {
        const stmt = this.db.prepare("SELECT id, titulo, descripcion, completada FROM tareas WHERE id = ?");
        const row = stmt.get(id) as any;
        if (!row) return undefined;
        return {
            ...row,
            completada: Boolean(row.completada)
        };
    }

    crear(titulo: string, descripcion?: string): Tarea {
        const id = Date.now().toString();

        const stmt = this.db.prepare("INSERT INTO tareas (id, titulo, descripcion, completada) VALUES (?, ?, ?, 0)");
        stmt.run(id, titulo, descripcion || null);

        return {
            id,
            titulo,
            descripcion,
            completada: false
        };
    }

    actualizar(tarea: Tarea): Tarea | undefined {
        const stmt = this.db.prepare("UPDATE tareas SET titulo = ?, descripcion = ?, completada = ? WHERE id = ?");
        const info = stmt.run(tarea.titulo, tarea.descripcion || null, tarea.completada ? 1 : 0, tarea.id);

        if (info.changes === 0) return undefined;
        return tarea;
    }

    borrar(id: IdTarea): boolean {
        const stmt = this.db.prepare("DELETE FROM tareas WHERE id = ?");
        const info = stmt.run(id);
        return info.changes > 0;
    }

    borrarTodas(): void {
        const stmt = this.db.prepare('DELETE FROM tareas');
        stmt.run();
    }

    guardar(tarea: Tarea): void {
        const stmt = this.db.prepare('INSERT OR REPLACE INTO tareas (id, titulo, descripcion, completada) VALUES (?, ?, ?, ?)');
        stmt.run(tarea.id, tarea.titulo, tarea.descripcion || null, tarea.completada ? 1 : 0);
    }
}