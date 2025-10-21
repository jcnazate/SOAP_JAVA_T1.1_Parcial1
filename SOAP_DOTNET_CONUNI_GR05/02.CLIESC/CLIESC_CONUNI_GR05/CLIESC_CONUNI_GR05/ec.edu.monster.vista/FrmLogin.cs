using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CLIESC_CONUNI_GR05.ec.edu.monster.vista
{
    public partial class FrmLogin : Form
    {
        public FrmLogin()
        {
            InitializeComponent();
        }

        // Getter y Setter para txtUsuario
        public string Usuario
        {
            get { return txtUsuario.Text; }
            set { txtUsuario.Text = value; }
        }

        // Getter y Setter para txtContrasena
        public string Contrasena
        {
            get { return txtContrasena.Text; }
            set { txtContrasena.Text = value; }
        }

        // Getter y Setter para lblMensaje
        public string Mensaje
        {
            get { return lblMensaje.Text; }
            set { lblMensaje.Text = value; }
        }

        // Método público para suscribir el evento del botón
        public void SuscribirEventoBoton(EventHandler handler)
        {
            btnLogin.Click += handler;
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }
    }
}
