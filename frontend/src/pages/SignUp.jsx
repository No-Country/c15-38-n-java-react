import { Link } from "react-router-dom";

export default function SignUp() {
  return (
    <div class="flex justify-center">
      <section className="border rounded-2xl w-[480px] p-[48px]">
        <div>
          <h1 className="text-3xl font-bold">Sign up</h1>
        </div>
        <div>
          <from>
            <div>
              <div class="h-[54px] flex items-end justify-between">
                <label for="email" className="text-base font-semibold">Email</label>
                <span class="text-sm font-normal">
                  Already have an account?
                  <Link to="/logIn">
                    <span class="ml-[6px] font-semibold">Log in</span>
                  </Link>
                </span>
              </div>
              <div class="h-[51px]">
                <input type="text" name="email" className="w-full h-full border rounded p-[14px]"></input>
              </div>
            </div>
            <div>
              <div class="h-[54px] flex items-end justify-between">
                <label for="current-password" className="text-base font-semibold">Password</label>
                <span class="text-sm font-semibold">
                  {/*<svg></svg>*/}
                  Show
                </span>
              </div>
              <div class="h-[51px]">
                <input type="text" name="email" className="w-full h-full border rounded p-[14px]"></input>
              </div>
            </div>
            <div>
              <button className="bg-black border rounded w-full h-[50px] text-lg text-white">
                Sign up
              </button>
            </div>
          </from>
          <div class="my-[18px] text-center">
            <span>
              -- or --
            </span>
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
