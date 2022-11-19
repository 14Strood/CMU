package pt.ipp.estg.cmu_retrofit.ui.model

data class POI (
    val name:String,
    val address:String,
    val category:String,
    val details:String,
    val location:String,
    val lat:Float,
    val lon:Float
    )