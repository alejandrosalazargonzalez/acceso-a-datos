package com.docencia.personas.services.impliments;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Rol;
import com.docencia.personas.services.IRoleService;
@SpringBootTest
@ActiveProfiles
public class RoleServiceTest {
    private static final String ROLL_1 = "ROLL-1";
    private static final String ROLE_NOMBRE = "Role nombre";
    IRoleService roleService;
    Rol rol = null;
    @Autowired
    public void setRoleService(IRoleService roleService){
        this.roleService = roleService;
    }

    @BeforeEach
    void beforeEach(){
        if (rol == null) {
            rol = new Rol(ROLL_1, ROLE_NOMBRE);
        }
        roleService.save(rol);
    }

    @AfterEach
    void afterEach(){
        Rol rolDelete = new Rol(ROLL_1);
        roleService.delete(rolDelete);
        rolDelete = roleService.findBy(rolDelete);
        Assertions.assertNull(rolDelete);
    }
    
    @Test
    void testFindBy() {
        Rol rolFind = new Rol(ROLL_1);
        rolFind = roleService.findBy(rolFind);
        Assertions.assertNotNull(rolFind);
        Assertions.assertEquals(rolFind, rol);
        Assertions.assertEquals(ROLL_1,rolFind.getId());
        Assertions.assertEquals(ROLE_NOMBRE, rolFind.getNombre());
    }

    @Test
    void testSave() {

    }
}
