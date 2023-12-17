import { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

export default function LogIn() {
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // Realizar la solicitud de inicio de sesión aquí
      const response = await axios.post("https://servilink-api.onrender.com/api/auth/login", formData);

      // Manejar la respuesta aquí, por ejemplo, redirigir al usuario a la página de inicio después del inicio de sesión
      console.log("Inicio de sesión exitoso:", response);

      // Redirigir a la página del dashboard o a donde desees
      history.push("/providerDashboard");
    } catch (error) {
      // Manejar errores aquí
      console.error("Error al iniciar sesión:", error);
    }
  };

  return (
    <div className="flex items-center justify-center mt-[150px]">
      <section className="border rounded-2xl w-[480px] p-[48px]">
        <div>
          <h1 className="text-3xl font-bold">Log in</h1>
        </div>
        <div>
          <form onSubmit={handleSubmit}>
            <div>
              <div className="h-[54px] flex items-end justify-between mb-4">
                <label htmlFor="email" className="text-base font-semibold">
                  Email
                </label>
                <span className="text-sm font-normal">
                  Need an account?
                  <Link to="/signUp">
                    <span className="ml-[6px] font-semibold">Sign up</span>
                  </Link>
                </span>
              </div>
              <div className="h-[51px]">
                <input
                  type="text"
                  name="email"
                  onChange={handleChange}
                  className="w-full h-full border rounded p-[14px]"
                />
              </div>
            </div>
            <div>
              <div className="h-[54px] flex items-end justify-between mb-4">
                <label
                  htmlFor="password"
                  className="text-base font-semibold"
                >
                  Password
                </label>
                <span className="text-sm font-semibold">
                  {/*<svg></svg>*/}
                  Show
                </span>
              </div>
              <div className="h-[51px]">
                <input
                  type="password"
                  name="password"
                  onChange={handleChange}
                  className="w-full h-full border rounded p-[14px]"
                />
              </div>
              <div className="h-[24px] my-[18px] text-sm font-normal text-center">
                <Link to="/forgotPassword">Forgot password?</Link>
              </div>
            </div>
            <button
              type="submit"
              className="bg-black border rounded w-full h-[50px] text-lg text-white"
            >
              Log in
            </button>
          </form>
          <div className="my-[18px] text-center">
            <span>-- or --</span>
          </div>
          <div>
            <button className="bg-white border rounded w-full h-[50px] text-base text-black">
              Continue with Google
            </button>
          </div>
        </div>
      </section>
    </div>
  );
}
