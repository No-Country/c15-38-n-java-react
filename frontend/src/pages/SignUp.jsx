import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { registrarUsuario } from "/api/api.js";

export default function SignUp() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await registrarUsuario(formData);

      // Handle the response
      console.log("Registro exitoso:", response);

      // Redirect to the /providerDashboard route
      navigate("/providerDashboard");
    } catch (error) {
      // Handle errors
      console.error("Error al registrar:", error);
    }
  };

  return (
    <section className="flex items-center justify-center mt-[150px]">
      <div className="border rounded-2xl w-[480px] p-[48px]">
        <div>
          <h1 className="text-3xl font-bold">Sign up</h1>
        </div>
        <div>
          <form onSubmit={handleSubmit}>
            <div>
              <div className="h-[54px] flex items-end justify-between">
                <label
                  htmlFor="name"
                  className="text-base font-semibold"
                >
                  Nombre
                </label>
                <span className="text-sm font-normal">
                  Ya tienes una cuenta?
                  <Link to="/logIn">
                    <span className="ml-[6px] font-semibold">Log in</span>
                  </Link>
                </span>
              </div>
              <div className="h-[51px] mt-4">
                <input
                  onChange={handleChange}
                  type="text"
                  name="firstName"
                  className="w-full h-full border rounded p-[14px]"
                />
              </div>
            </div>

            <div>
              <div className="h-[54px] flex items-end justify-between">
                <label
                  htmlFor="email"
                  className="text-base font-semibold"
                >
                  Email
                </label>
              </div>
              <div className="h-[51px] mt-4">
                <input
                  onChange={handleChange}
                  type="text"
                  name="email"
                  className="w-full h-full border rounded p-[14px]"
                />
              </div>
            </div>

            <div>
              <div className="h-[54px] flex items-end justify-between">
                <label
                  htmlFor="current-password"
                  className="text-base font-semibold"
                >
                  Contranseña
                </label>
                <span className="text-sm font-semibold">Show</span>
              </div>
              <div className="h-[51px] mt-4">
                <input
                  onChange={handleChange}
                  type="password"
                  name="password"
                  className="w-full h-full border rounded p-[14px]"
                />
              </div>
            </div>

            <div className="mt-8">
              <button className="bg-black border rounded w-full h-[50px] text-lg text-white">
                Sign up
              </button>
            </div>
          </form>

          <div className="my-[18px] text-center">
            <span>-- or --</span>
          </div>

          <div>
            <button className="bg-white border rounded w-full h-[50px] text-base text-black">
              Continuar con Google
            </button>
          </div>
        </div>
      </div>
    </section>
  );
}
