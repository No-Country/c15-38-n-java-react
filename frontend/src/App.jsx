import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import HomeCleaning from "./pages/HomeCleaning";
import GardeningServices from "./pages/GardeningServices";
import HomeOrganization from "./pages/HomeOrganization";
import LogIn from "./pages/LogIn";
import SignUp from "./pages/SignUp";
import ProviderDashboard from "./pages/ProviderDashboard";

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
              path="/providerDashboard"
              element={<ProviderDashboard />}
            />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
