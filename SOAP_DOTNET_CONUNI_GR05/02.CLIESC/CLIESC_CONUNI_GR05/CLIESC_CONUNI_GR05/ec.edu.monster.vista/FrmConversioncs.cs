using System;
using System.Windows.Forms;

namespace CLIESC_CONUNI_GR05.ec.edu.monster.vista
{
    public partial class FrmConversioncs : Form
    {
        public FrmConversioncs()
        {
            InitializeComponent();
            // Asociar eventos para validar entrada en tiempo real
            txtCM.KeyPress += TxtCM_KeyPress;
            txtIN.KeyPress += TxtIN_KeyPress;
        }

        private void TxtCM_KeyPress(object sender, KeyPressEventArgs e)
        {
            // Permitir solo números, coma y teclas de control (como borrar)
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && e.KeyChar != ',')
            {
                e.Handled = true; // Bloquear teclas no permitidas
            }

            // Evitar más de una coma
            if (e.KeyChar == ',' && ((TextBox)sender).Text.Contains(","))
            {
                e.Handled = true;
            }
        }

        private void TxtIN_KeyPress(object sender, KeyPressEventArgs e)
        {
            // Misma lógica para txtIN
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && e.KeyChar != ',')
            {
                e.Handled = true; // Bloquear teclas no permitidas
            }

            if (e.KeyChar == ',' && ((TextBox)sender).Text.Contains(","))
            {
                e.Handled = true;
            }
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
        }

        public string Centimetros
        {
            get { return txtCM.Text; }
            set { txtCM.Text = value; }
        }

        public string Pulgadas
        {
            get { return txtIN.Text; }
            set { txtIN.Text = value; }
        }

        public string ResultadoCM
        {
            get { return txtResulCM.Text; }
            set { txtResulCM.Text = value; }
        }

        public string ResultadoIN
        {
            get { return txtResulIN.Text; }
            set { txtResulIN.Text = value; }
        }

        public string Mensaje
        {
            get { return lblMensaje.Text; }
            set { lblMensaje.Text = value; }
        }

        public void btnConvertirCM(EventHandler handler)
        {
            btnINaCM.Click += handler;
        }

        public void btnConvertirIN(EventHandler handler)
        {
            btnCMAaIN.Click += handler;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }
    }
}