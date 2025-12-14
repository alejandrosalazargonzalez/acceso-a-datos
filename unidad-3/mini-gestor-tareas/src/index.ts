import { ServicioTareas } from './servicioTareas';

async function main() {
    const servicio = new ServicioTareas();

    try {
        console.log('--- CREANDO TAREA REMOTA ---');
        const nuevaTarea = await servicio.crear({
            titulo: 'Tarea Remota de prueba',
            descripcion: 'Creada desde Node CLI',
            completada: false
        }, 'remoto');
        console.log('Creada:', nuevaTarea);

        console.log('\n--- LISTANDO TAREAS REMOTAS ---');
        const remotas = await servicio.listar('remoto');
        console.table(remotas);

        console.log('\n--- SINCRONIZANDO (REMOTO -> LOCAL) ---');
        await servicio.sincronizarRemotoALocal();
        console.log('Sincronización completada.');

        console.log('\n--- LISTANDO TAREAS LOCALES (SQLITE) ---');
        const locales = await servicio.listar('local');
        console.table(locales);

    } catch (error) {
        console.error('Ocurrió un error:', error);
    }
}

main();