using CLICLON_CONUNI_GR05.ConversionServiceReference;
using CLICLON_CONUNI_GR05.ec.edu.monster.controlador;
using CLICLON_CONUNI_GR05.ec.edu.monster.modelo;
using CLICLON_CONUNI_GR05.ec.edu.monster.vista;
using CLICLON_CONUNI_GR05.LoginServiceReference;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace CLICLON_CONUNI_GR05
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Inicializar las clases MVC
            LoginConverModelo modelo = new LoginConverModelo();
            LoginConverVista vista = new LoginConverVista();
            LoginConverControlador controlador = new LoginConverControlador(modelo, vista);

            // Iniciar el programa
            controlador.Iniciar();
        }
    }
}
