// src/db.ts
import Database from "better-sqlite3";

const DB_FILE = "tareas.db";

let db: Database.Database | null = null;

export function getDb(): Database.Database {
    if (!db) {
        db = new Database(DB_FILE);

        db.exec(`
        CREATE TABLE IF NOT EXISTS tareas (
            id TEXT PRIMARY KEY,
            titulo TEXT NOT NULL,
            descripcion TEXT,
            completada INTEGER NOT NULL
        )
    `);
    }

    return db;
}