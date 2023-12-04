export default function Navbar() {
  return (
    <nav className="p-4 ">
      <div className="flex items-center justify-between">
        <div className="flex items-center gap-2">
          <img
            className="w-6 "
            src="public/logo.svg"
            alt="Logo"
          />
          <p className="hidden md:block">ServiLink</p>
        </div>

        <div>
          <p>search bar</p>
        </div>

        <div>Profile</div>
      </div>

      <ul className=" slider">
        <li>Servicios del Hogar</li>
        <li>Mantenimiento del Jardín</li>
        <li>Servicios de Reparación</li>
        <li>Servicios de Salud y Bienestar</li>
        <li>Masajes a domicilio</li>
        <li>Entrenamiento personal</li>
        <li>Servicios de Belleza</li>
        <li>Transporte y Entregas</li>
        <li>Servicios Profesionales</li>
        <li>Educación y Tutorías</li>
        <li>Eventos y Entretenimiento</li>
        <li>Servicios de Tecnología</li>
      </ul>
    </nav>
  );
}
