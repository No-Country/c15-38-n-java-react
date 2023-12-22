import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import HomeCleaning from "./pages/HomeCleaning";
import GardeningServices from "./pages/GardeningServices";
import HomeOrganization from "./pages/HomeOrganization";
import LogIn from "./pages/LogIn";
import SignUp from "./pages/SignUp";
import ProviderDashboard from "./pages/ProviderDashboard";
import AddService from "./pages/AddService";
import UpdateProviderData from "./pages/UpdateProviderData";
import Service from "./pages/Service";


function App() {
  return (
    <div className="flex flex-col min-h-screen">
      <Router>
        <Navbar />
        <div>
          <Routes>
            <Route
              path="/"
              element={<HomeCleaning />}
            />
            <Route
              path="/gardeningServices"
              element={<GardeningServices />}
            />
            <Route
              path="/homeOrganization"
              element={<HomeOrganization />}
            />
            <Route
              path="/logIn"
              element={<LogIn />}
            />
            <Route
              path="/signUp"
              element={<SignUp />}
            />
            <Route
              path="/service"
              element={<Service />}
            />
            <Route
              path="/providerDashboard"
              element={<ProviderDashboard />}
            />

            <Route
              path="/addService"
              element={<AddService />}
            />
            <Route
              path="/updateProviderData"
              element={<UpdateProviderData />}

            />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
