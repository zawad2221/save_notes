object Modules {
    const val base = ":base"
    
    object Feature {
        const val notes = ":feature:notes"
        const val search = ":feature:search"
    }
    
    object Data {
        const val notes = ":core:data:notes"
    }

    object Core {
        const val designSystem = ":core:ui:design-system"
        const val api = ":core:api"
        const val dimens = ":core:ui:dimens"
        const val fonts = ":core:ui:fonts"
        const val commonui = ":core:ui:commonui"
        const val constants = ":core:constants"
        const val database = ":core:database"
        const val common = ":core:common"
        const val datastore = ":core:datastore"
        const val datastoreProto = ":core:datastore-proto"
    }
}
