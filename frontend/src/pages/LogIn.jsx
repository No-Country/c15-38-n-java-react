import { Link } from "react-router-dom";

export default function LogIn() {
  return (
    <div className="flex justify-center">
      <section className="border rounded-2xl w-[480px] p-[48px]">
        <div>
          <h1 className="text-3xl font-bold">Log in</h1>
        </div>
        <div>
          <from>
            <div>
              <div className="h-[54px] flex items-end justify-between">
                <label
                  htmlFor="email"
                  className="text-base font-semibold"
                >
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
                  className="w-full h-full border rounded p-[14px]"
                ></input>
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
                <span className="text-sm font-semibold">
                  {/*<svg></svg>*/}
                  Show
                </span>
              </div>
              <div className="h-[51px]">
                <input
                  type="text"
                  name="email"
                  className="w-full h-full border rounded p-[14px]"
                ></input>
              </div>
              <div className="h-[24px] my-[18px] text-sm font-normal text-center">
                <a>Forgot password?</a>
              </div>
            </div>
            <Link to="/providerDashboard">
              <button className="bg-black border rounded w-full h-[50px] text-lg text-white">
                Log in
              </button>
            </Link>
          </from>
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
