import React from "react";
import { Route, Redirect } from "react-router-dom";
import auth from "./components/Signin/auth";

export const ProtectedRoute = ({
  component: Component,
  ...rest
}) => {
  return (
    <Route
      {...rest}
      render={props => {
        if (sessionStorage.getItem("isLoggedIn") === "true") {
          return <Component {...props} />;
        } else {
          return (
            <Redirect
              to={{
                pathname: "/",
                state: {
                  from: props.location
                }
              }}
            />
          );
        }
      }}
    />
  );
};


// src/components/Signin/auth.js