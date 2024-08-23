package com.questcontrol;

import com.questcontrol.capitulo.infraestructure.controller.CapituloConsoleAdapter;
import com.questcontrol.catalogo.infraestructure.controller.CategoriaCatalogoConsoleAdapter;
import com.questcontrol.formulario.infraestructure.controller.FormularioConsoleAdapter;
import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.opcionrespuesta.infraestructure.controller.OpcionRespuestaConsoleAdapter;
import com.questcontrol.opcionsubrespuesta.infraestructure.controller.OpcionSubRespuestaConsoleAdapter;
import com.questcontrol.pregunta.infraestructure.controller.PreguntaConsoleAdapter;
import com.questcontrol.respuestapregunta.infraestructure.controller.RespuestaPreguntaConsoleAdapter;
import com.questcontrol.usuario.infraestructure.controller.UsuarioConsoleAdapter;
import com.questcontrol.rol.infraestructure.controller.RolConsoleAdapter;
import com.questcontrol.rolusuario.infraestructure.controller.RolUsuarioConsoleAdapter;

import java.util.Scanner;

public class iu {
    public static void mainMenu(){
        System.out.println("Quest Control");
        Scanner scanner = new Scanner(System.in);

        boolean flag =true;
        String menu= " 1. Usuarios\n 2. Roles\n 3. Roles usuario\n 4. Capitulos\n 5.Categoria Catalogo\n 6. Preguntas\n 7. Formularios\n 8. Respuestas\n 9. Sub Respuestas \n 10. Respuestas preguntas \n 11. Salir";
        while (flag){
            
            System.out.println(menu);
            int options= scanner.nextInt();
            AditionalFuntions.clearConsole();
            switch (options){
                case 1:
                    UsuarioConsoleAdapter csu = new UsuarioConsoleAdapter();
                    csu.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 2:
                    RolConsoleAdapter csr = new RolConsoleAdapter();
                    csr.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 3:
                    RolUsuarioConsoleAdapter csru = new RolUsuarioConsoleAdapter();
                    csru.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 4:
                    CapituloConsoleAdapter csrcap = new CapituloConsoleAdapter();
                    csrcap.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 5:
                    CategoriaCatalogoConsoleAdapter csrcat = new CategoriaCatalogoConsoleAdapter();
                    csrcat.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 6:
                    PreguntaConsoleAdapter csrp = new PreguntaConsoleAdapter();
                    csrp.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 7:
                    FormularioConsoleAdapter csrf = new FormularioConsoleAdapter();
                    csrf.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 8:
                    OpcionRespuestaConsoleAdapter csror = new OpcionRespuestaConsoleAdapter();
                    csror.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 9:
                    OpcionSubRespuestaConsoleAdapter csrosub = new OpcionSubRespuestaConsoleAdapter();
                    csrosub.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 10:
                    RespuestaPreguntaConsoleAdapter csrrp = new RespuestaPreguntaConsoleAdapter();
                    csrrp.Start();
                    AditionalFuntions.clearConsole();
                    break;
                case 11:
                    flag=false;
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Invalid Option, Try again.");
            }
        }
        scanner.close();
    }
}
