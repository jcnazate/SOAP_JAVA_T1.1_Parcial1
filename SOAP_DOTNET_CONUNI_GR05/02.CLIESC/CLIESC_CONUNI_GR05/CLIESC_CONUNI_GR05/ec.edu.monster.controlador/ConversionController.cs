using CLIESC_CONUNI_GR05.ec.edu.monster.modelo;
using CLIESC_CONUNI_GR05.ec.edu.monster.vista;
using System;
using System.Windows.Forms;
using System.Globalization;

namespace CLIESC_CONUNI_GR05.ec.edu.monster.controlador
{
    public class ConversionController
    {
        private readonly ServiceManager _serviceManager;
        private readonly FrmConversioncs _frmConversion;

        public ConversionController()
        {
            _serviceManager = new ServiceManager();
            _frmConversion = new FrmConversioncs();
            _frmConversion.btnConvertirCM(BtnConvertirINaCM_Click);
            _frmConversion.btnConvertirIN(BtnConvertirCMaIN_Click);
        }

        public void ShowConversion()
        {
            Application.Run(_frmConversion);
        }

        private void BtnConvertirINaCM_Click(object sender, EventArgs e)
        {
            try
            {
                // Reemplazar coma por punto para parsear correctamente
                string inputPulgadas = _frmConversion.Pulgadas.Replace(",", ".");

                // Parsear el valor
                if (double.TryParse(inputPulgadas, NumberStyles.Any, CultureInfo.InvariantCulture, out double pulgadas))
                {
                    // Validar que el número sea mayor a 0
                    if (pulgadas <= 0)
                    {
                        ActualizarMensaje("Ingrese un valor válido");
                        return;
                    }

                    double resultado = _serviceManager.PulgadasACentimetros(pulgadas);

                    if (_frmConversion.InvokeRequired)
                    {
                        _frmConversion.Invoke(new Action(() =>
                        {
                            // Mostrar resultado con coma como separador decimal
                            _frmConversion.ResultadoCM = resultado.ToString("F2", new CultureInfo("es-ES"));
                            _frmConversion.Mensaje = "Conversión exitosa";
                        }));
                    }
                    else
                    {
                        _frmConversion.ResultadoCM = resultado.ToString("F2", new CultureInfo("es-ES"));
                        _frmConversion.Mensaje = "Conversión exitosa";
                    }
                }
                else
                {
                    ActualizarMensaje("Ingrese un valor válido");
                }
            }
            catch (Exception ex)
            {
                ActualizarMensaje("Ingrese un valor válido");
            }
        }

        private void BtnConvertirCMaIN_Click(object sender, EventArgs e)
        {
            try
            {
                // Reemplazar coma por punto para parsear correctamente
                string inputCentimetros = _frmConversion.Centimetros.Replace(",", ".");

                // Parsear el valor
                if (double.TryParse(inputCentimetros, NumberStyles.Any, CultureInfo.InvariantCulture, out double centimetros))
                {
                    // Validar que el número sea mayor a 0
                    if (centimetros <= 0)
                    {
                        ActualizarMensaje("Ingrese un valor válido");
                        return;
                    }

                    double resultado = _serviceManager.CentimetrosAPulgadas(centimetros);

                    if (_frmConversion.InvokeRequired)
                    {
                        _frmConversion.Invoke(new Action(() =>
                        {
                            // Mostrar resultado con coma como separador decimal
                            _frmConversion.ResultadoIN = resultado.ToString("F2", new CultureInfo("es-ES"));
                            _frmConversion.Mensaje = "Conversión exitosa";
                        }));
                    }
                    else
                    {
                        _frmConversion.ResultadoIN = resultado.ToString("F2", new CultureInfo("es-ES"));
                        _frmConversion.Mensaje = "Conversión exitosa";
                    }
                }
                else
                {
                    ActualizarMensaje("Ingrese un valor válido");
                }
            }
            catch (Exception ex)
            {
                ActualizarMensaje("Ingrese un valor válido");
            }
        }

        private void ActualizarMensaje(string mensaje)
        {
            if (_frmConversion.InvokeRequired)
            {
                _frmConversion.Invoke(new Action(() => _frmConversion.Mensaje = mensaje));
            }
            else
            {
                _frmConversion.Mensaje = mensaje;
            }
        }
    }
}