(ns android-json-server.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))
(defn hello [req]
  (println req)
  "Hello World"
  )

(defn helloJson [req]
  (println req)
  "\"hello world\"" 
  )

(defn getUser [req]
  (println req)
  "{\"name\":\"taro\",\"age\":77}" 
  )

(defn postUser [req]
  (println req)
  "{\"name\":\"jiro\",\"age\":33}" 
  )

(defroutes app-routes
  (ANY "/api/users/create" req (postUser req) )
  (GET "/" [] hello)
  (POST "/osc/commands/execute" [] helloJson)
  (GET "/api/user" [] getUser)
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults  (assoc-in site-defaults [:security :anti-forgery] false)))
  )
