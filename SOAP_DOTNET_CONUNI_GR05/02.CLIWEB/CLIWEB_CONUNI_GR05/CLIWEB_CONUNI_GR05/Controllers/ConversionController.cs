using CLIWEB_CONUNI_GR05.Models;
using Microsoft.AspNetCore.Mvc;

namespace CLIWEB_CONUNI_GR05.Controllers
{
    public class ConversionController : Controller
    {
        private readonly LoginConverModelo servicios;

        public ConversionController()
        {
            servicios = new LoginConverModelo();
        }

        public IActionResult Index()
        {
            var usuario = HttpContext.Session.GetString("usuario");
            if (usuario == null)
            {
                return RedirectToAction("Index", "Login");
            }

            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Convertir(double cantidad, string tipo)
        {
            var usuario = HttpContext.Session.GetString("usuario");
            if (usuario == null)
            {
                return RedirectToAction("Index", "Login");
            }

            //double resultado = 0;
            if (tipo == "cm")
                //resultado = await servicios.PulgadasACentimetrosAsync(cantidad);
                ViewBag.ResultadoCm = await servicios.PulgadasACentimetrosAsync(cantidad);
            else if (tipo == "in")
                //resultado = await servicios.CentimetrosAPulgadasAsync(cantidad);
                ViewBag.ResultadoIn = await servicios.CentimetrosAPulgadasAsync(cantidad);

            //ViewBag.Resultado = resultado;
            return View("Index");
        }
    }
}
