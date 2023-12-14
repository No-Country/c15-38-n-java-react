import { Link } from "react-router-dom";

export default function SignUp() {
  return (
    <section className="flex items-center justify-center mt-[150px]">
      <div className="border rounded-2xl w-[480px] p-[48px]">
        <div>
          <h1 className="text-3xl font-bold">Sign up</h1>
        </div>
        <div>
          <form>
            <div>
              <div className="h-[54px] flex items-end justify-between">
                <label
                  htmlFor="name"
                  className="text-base font-semibold"
                >
                  Name
                </label>
                <span className="text-sm font-normal">
                  Already have an account?
                  <Link to="/logIn">
                    <span className="ml-[6px] font-semibold">Log in</span>
                  </Link>
                </span>
              </div>
              <div className="h-[51px] mt-4">
                <input
                  type="text"
                  name="name"
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
                  Password
                </label>
                <span className="text-sm font-semibold">Show</span>
              </div>
              <div className="h-[51px] mt-4">
                <input
                  type="text"
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
              Continue with Google
            </button>
          </div>
        </div>
      </div>
    </section>
  );
}
