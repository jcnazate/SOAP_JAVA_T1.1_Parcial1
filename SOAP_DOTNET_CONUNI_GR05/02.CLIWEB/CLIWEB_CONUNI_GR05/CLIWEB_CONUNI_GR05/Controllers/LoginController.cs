using CLIWEB_CONUNI_GR05.Models;
using Microsoft.AspNetCore.Mvc;

namespace CLIWEB_CONUNI_GR05.Controllers
{
    public class LoginController : Controller
    {
        private readonly LoginConverModelo servicios;

        public LoginController()
        {
            servicios = new LoginConverModelo();
        }

        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Index(string usuario, string clave)
        {
            bool autenticado = await servicios.AutenticarAsync(usuario, clave);
            if (!autenticado)
            {
                ViewBag.Mensaje = "Usuario o contraseña incorrectos.";
                return View();
            }

            HttpContext.Session.SetString("usuario", usuario);
            return RedirectToAction("Index", "Conversion");
        }
    }
}
