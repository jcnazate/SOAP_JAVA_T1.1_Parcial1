using CLIESC_CONUNI_GR05.ec.edu.monster.modelo;
using CLIESC_CONUNI_GR05.ec.edu.monster.vista;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CLIESC_CONUNI_GR05.ec.edu.monster.controlador
{
    public class LoginController
    {
        private readonly ServiceManager _serviceManager;
        private readonly FrmLogin _frmLogin;
        private bool _loginSuccess;

        public LoginController()
        {
            _serviceManager = new ServiceManager();
            _frmLogin = new FrmLogin();
            _frmLogin.SuscribirEventoBoton(BtnLogin_Click);
            _loginSuccess = false;
        }

        public bool ShowLogin()
        {
            _frmLogin.ShowDialog(); // Mostrar como diálogo
            return _loginSuccess; // Devolver si el login fue exitoso
        }

        private void BtnLogin_Click(object sender, EventArgs e)
        {
            try
            {
                bool resultado = _serviceManager.Autenticar(_frmLogin.Usuario, _frmLogin.Contrasena);

                if (_frmLogin.InvokeRequired)
                {
                    _frmLogin.Invoke(new Action(() =>
                    {
                        _frmLogin.Mensaje = resultado ? "Autenticación exitosa" : "Autenticación fallida";
                        if (resultado)
                        {
                            _loginSuccess = true;
                            _frmLogin.Close(); // Cerrar el formulario de login
                        }
                    }));
                }
                else
                {
                    _frmLogin.Mensaje = resultado ? "Autenticación exitosa" : "Autenticación fallida";
                    if (resultado)
                    {
                        _loginSuccess = true;
                        _frmLogin.Close();
                    }
                }
            }
            catch (Exception ex)
            {
                ActualizarMensaje("Error: " + ex.Message);
            }
        }

        private void ActualizarMensaje(string mensaje)
        {
            if (_frmLogin.InvokeRequired)
            {
                _frmLogin.Invoke(new Action(() => _frmLogin.Mensaje = mensaje));
            }
            else
            {
                _frmLogin.Mensaje = mensaje;
            }
        }
    }
}