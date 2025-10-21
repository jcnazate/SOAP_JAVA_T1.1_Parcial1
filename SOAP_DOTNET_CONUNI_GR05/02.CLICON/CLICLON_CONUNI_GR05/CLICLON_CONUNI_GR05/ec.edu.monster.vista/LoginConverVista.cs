using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLICLON_CONUNI_GR05.ec.edu.monster.vista
{
    public class LoginConverVista
    {
        public (string user, string password) PedirCredenciales()
        {
            Console.WriteLine("=== Sistema de Conversión de Unidades ===");
            Console.Write("Usuario: ");
            string user = Console.ReadLine();
            Console.Write("Contraseña: ");
            string password = Console.ReadLine();
            return (user, password);
        }

        public void MostrarMensajeAutenticacion(bool exito)
        {
            if (exito)
            {
                Console.WriteLine("Autenticación exitosa. Bienvenido(a)!");
            }
            else
            {
                Console.WriteLine("Error: Usuario o contraseña incorrectos.");
            }
        }

        public int MostrarMenu()
        {
            int opcion;
            bool opcionValida;

            do
            {
                Console.WriteLine("\n=== Menú de Conversión ===");
                Console.WriteLine("1. Pulgadas a Centímetros");
                Console.WriteLine("2. Centímetros a Pulgadas");
                Console.WriteLine("3. Salir");
                Console.Write("Seleccione una opción (1-3): ");

                opcionValida = int.TryParse(Console.ReadLine(), out opcion);
                if (!opcionValida || opcion < 1 || opcion > 3)
                {
                    Console.WriteLine("Error: Por favor, seleccione una opción válida (1-3).");
                    opcionValida = false;
                }
            } while (!opcionValida);

            return opcion;
        }

        public double PedirValor(string unidad)
        {
            double valor;
            bool valorValido;

            do
            {
                Console.Write($"Ingrese el valor en {unidad}: ");
                valorValido = double.TryParse(Console.ReadLine(), out valor);
                if (!valorValido || valor <= 0)
                {
                    Console.WriteLine("Error: Por favor, ingrese un número positivo mayor a 0.");
                    valorValido = false;
                }
            } while (!valorValido);

            return valor;
        }

        public void MostrarResultado(string tipoConversion, double valorOriginal, double valorConvertido, string unidadOriginal, string unidadConvertida)
        {
            Console.WriteLine($"\nResultado de {tipoConversion}:");
            Console.WriteLine($"{valorOriginal} {unidadOriginal} = {valorConvertido} {unidadConvertida}");
        }

        public void MostrarMensajeError(string mensaje)
        {
            Console.WriteLine($"Error: {mensaje}");
        }

        public void MostrarMensajeSalida()
        {
            Console.WriteLine("\nGracias por usar el sistema. ¡Hasta luego!");
        }
    }
}
