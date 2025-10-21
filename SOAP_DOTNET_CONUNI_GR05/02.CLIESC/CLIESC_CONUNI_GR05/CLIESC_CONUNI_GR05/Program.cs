using CLIESC_CONUNI_GR05.ec.edu.monster.controlador;
using CLIESC_CONUNI_GR05.ec.edu.monster.vista;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CLIESC_CONUNI_GR05
{
    internal static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            // Iniciar el flujo de la aplicación
            RunApplication();
        }

        private static void RunApplication()
        {
            // Iniciar con el controlador de login
            LoginController loginController = new LoginController();

            // Mostrar el formulario de login y esperar el resultado
            if (loginController.ShowLogin())
            {
                // Si el login es exitoso, mostrar el formulario de conversiones
                ConversionController conversionController = new ConversionController();
                conversionController.ShowConversion();
            }
        }
    }
}