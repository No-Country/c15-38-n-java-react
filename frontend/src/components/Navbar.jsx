import { useState, useEffect } from "react";
import { Link, useLocation } from "react-router-dom";

export default function Navbar() {
  const location = useLocation();
  const [services, setServices] = useState([]);

  useEffect(() => {
    // Fetch data from the backend API
    const fetchData = async () => {
      try {
        const response = await fetch(
          "https://servilink-api.onrender.com/api/service/get-all-services"
        );
        const data = await response.json();
        setServices(data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    // Call the fetch function
    fetchData();
  }, []); // Empty dependency array ensures that this effect runs only once on component mount

  const isLoginPage = location.pathname === "/logIn";
  const isSignUpPage = location.pathname === "/signUp";
  const isProviderDashboardPage = location.pathname === "/providerDashboard";
  const isAddServicePage = location.pathname === "/addService";
  const isUpdateProviderDataPage = location.pathname === "/updateProviderData";

  const navigationOptions =
    isProviderDashboardPage || isAddServicePage || isUpdateProviderDataPage
      ? [
          { to: "/providerDashboard", label: "Inicio" },
          { to: "/addService", label: "Agregar servicio" },
          { to: "/updateProviderData", label: "Actualizar datos" },
          { to: "/Limpiezadelhogar", label: "Cerrar Sesion" },
        ]
      : !isLoginPage && !isSignUpPage
      ? services.map((service) => ({
          to: `/${service.service.replace(/\s+/g, "")}`,
          label: service.service,
        }))
      : [];

  return (
    <nav className="fixed top-0 left-0 z-10 w-full px-4 md:px-10 pt-4 overflow-hidden lg:px-0 bg-white lg:w-[59rem] lg:left-1/2 xl:w-[80rem] 2xl:w-[90rem] lg:-translate-x-1/2 lg:transform">
      <div className="flex items-center justify-between">
        <Link to="/Limpiezadelhogar">
          <div className="flex items-center gap-2">
            <img
              className="w-6 xl:w-8"
              src="./images/Logo.svg"
              alt="Logo"
            />
            <span className="hidden text-xl font-medium md:block ">
              ServiLink
            </span>
          </div>
        </Link>

        <div className="flex items-center gap-4">
          {!isLoginPage &&
            !isSignUpPage &&
            !isProviderDashboardPage &&
            !isAddServicePage &&
            !isUpdateProviderDataPage && (
              <>
                <Link to="/logIn">
                  <button className="text-white text-xs lg:text-base bg-black rounded-lg w-[60px] h-[30px] lg:w-[98px] lg:h-[40px]">
                    Log in
                  </button>
                </Link>
                <Link to="/signUp">
                  <button className="rounded-lg w-[60px] h-[30px] lg:w-[98px] lg:h-[40px] border-2 border-black text-xs lg:text-base">
                    Sign Up
                  </button>
                </Link>
              </>
            )}
        </div>
      </div>

      {!isLoginPage && !isSignUpPage && (
        <div className="mt-6 overflow-x-auto hide-scrollbar">
          <ul className="flex space-x-4">
            {navigationOptions.map((option, index) => (
              <Link
                key={index}
                to={option.to}
                className="flex-shrink-0 px-4 py-2 bg-gray-200 rounded"
              >
                {option.label}
              </Link>
            ))}
          </ul>
        </div>
      )}
    </nav>
  );
}
