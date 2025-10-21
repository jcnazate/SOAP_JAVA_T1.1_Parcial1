using CLICLON_CONUNI_GR05.ec.edu.monster.modelo;
using CLICLON_CONUNI_GR05.ec.edu.monster.vista;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace CLICLON_CONUNI_GR05.ec.edu.monster.controlador
{
    public class LoginConverControlador
    {
        private readonly LoginConverModelo modelo;
        private readonly LoginConverVista vista;

        public LoginConverControlador(LoginConverModelo modelo, LoginConverVista vista)
        {
            this.modelo = modelo;
            this.vista = vista;
        }

        public void Iniciar()
        {
            // Pedir y validar credenciales
            bool autenticado = false;
            while (!autenticado)
            {
                var (user, password) = vista.PedirCredenciales();
                try
                {
                    autenticado = modelo.Autenticar(user, password);
                    vista.MostrarMensajeAutenticacion(autenticado);
                    if (!autenticado)
                    {
                        Console.WriteLine("Por favor, intente de nuevo.");
                    }
                }
                catch (System.ServiceModel.EndpointNotFoundException)
                {
                    vista.MostrarMensajeError("No se pudo conectar al servicio. Asegúrese de que el servicio WCF esté ejecutándose.");
                    return;
                }
                catch (System.ServiceModel.FaultException ex)
                {
                    vista.MostrarMensajeError(ex.Message);
                    return;
                }
            }

            // Mostrar menú y procesar conversiones
            bool salir = false;
            while (!salir)
            {
                int opcion = vista.MostrarMenu();
                switch (opcion)
                {
                    case 1: // Pulgadas a Centímetros
                        double pulgadas = vista.PedirValor("pulgadas");
                        try
                        {
                            double centimetros = modelo.PulgadasACentimetros(pulgadas);
                            vista.MostrarResultado("Pulgadas a Centímetros", pulgadas, centimetros, "pulgadas", "cm");
                        }
                        catch (System.ServiceModel.EndpointNotFoundException)
                        {
                            vista.MostrarMensajeError("No se pudo conectar al servicio. Asegúrese de que el servicio WCF esté ejecutándose.");
                            return;
                        }
                        catch (System.ServiceModel.FaultException ex)
                        {
                            vista.MostrarMensajeError(ex.Message);
                        }
                        break;

                    case 2: // Centímetros a Pulgadas
                        double cm = vista.PedirValor("centímetros");
                        try
                        {
                            double pulgadasConvertidas = modelo.CentimetrosAPulgadas(cm);
                            vista.MostrarResultado("Centímetros a Pulgadas", cm, pulgadasConvertidas, "cm", "pulgadas");
                        }
                        catch (System.ServiceModel.EndpointNotFoundException)
                        {
                            vista.MostrarMensajeError("No se pudo conectar al servicio. Asegúrese de que el servicio WCF esté ejecutándose.");
                            return;
                        }
                        catch (System.ServiceModel.FaultException ex)
                        {
                            vista.MostrarMensajeError(ex.Message);
                        }
                        break;

                    case 3: // Salir
                        salir = true;
                        vista.MostrarMensajeSalida();
                        break;
                }
            }
        }
    }
}
