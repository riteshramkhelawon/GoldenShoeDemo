package goldenshoe

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"home", action:"index")
        "/trackOrder"(view: "/trackOrder")
        "/faqs"(view: "/faqs")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
