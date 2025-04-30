import { Avatar, Button } from "@mui/material";
import React from "react";
import "./Navbar.css";


const Navbar = () => {
    return(
        <div className="z-10 stiky left-0 right-0 top-0 py-3 px-5 lg:px-10, flex justify-between items-center">

            <div>
                <p className="font-bold text-lg">Tasks</p>
                <p className="text-xs">All Tasks</p>
            </div>

            <div className="flex items-center gap-5">
                <span>
                    <Button color="" className="border">New Task</Button>
                </span>
            </div>


        </div>
    )
}

export default Navbar