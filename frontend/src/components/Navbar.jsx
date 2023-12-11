import { Link } from "react-router-dom";

export default function Navbar() {
  const services = [
    { to: "/", label: "Limpieza del hogar" },
    { to: "/gardeningServices", label: "Mantenimiento del jardín" },
    { to: "/homeOrganization", label: "Organización del hogar" },
  ];

  return (
    <nav className="fixed top-0 left-0 z-10 w-full px-4 md:px-10 pt-4 overflow-hidden lg:px-0 bg-white lg:w-[59rem] lg:left-1/2 xl:w-[80rem] 2xl:w-[90rem] lg:-translate-x-1/2 lg:transform">
      <div className="flex items-center justify-between">
        <div className="flex items-center gap-2">
          <img
            className="w-6 xl:w-8"
            src="/public/images/logo.svg"
            alt="Logo"
          />
          <span className="hidden text-xl font-medium md:block ">
            ServiLink
          </span>
        </div>

        <div className="flex items-center gap-4">
          <button className="text-white text-xs lg:text-base bg-black rounded-lg w-[70px] h-[30px] lg:w-[98px] lg:h-[40px]">
            Log in
          </button>
          <button className="rounded-lg w-[70px] h-[30px] lg:w-[98px] lg:h-[40px] border-2 border-black text-xs lg:text-base">
            Sign Up
          </button>
        </div>
      </div>

      <div className="mt-6 overflow-x-auto hide-scrollbar">
        <ul className="flex space-x-4">
          {services.map((service, index) => (
            <Link
              key={index}
              to={service.to}
              className="flex-shrink-0 px-4 py-2 bg-gray-200 rounded"
            >
              {service.label}
            </Link>
          ))}
        </ul>
      </div>
    </nav>
  );
}
