import React from 'react';
import './styles/App.css'
import {BrowserRouter, createBrowserRouter, Route, Router} from "react-router-dom";
import About from "./pages/About";

export function App() {

    const router = createBrowserRouter(
        createRoutesFromElements(
            <Route path="/" element={<Root />}>
                <Route path="dashboard" element={<Dashboard />} />
                {/* ... etc. */}
            </Route>
        )
    );

    return (
        <RouterPr
    );
}