package net.eviera.canilleras.util

object Global {

    const val EXTRA_START_SCAN_QR = "EXTRA_START_SCAN_QR"

    enum class TipoCanillera(private val desc: String) {
        KIDS("Kids"),
        MINI("Mini"),
        STAN("Stan"),
        FLEX("Flex"),
        STAN_C("Stan C"),
        FLEX_C("Flex C"),
        EURO("Euro")
        ;

        override fun toString(): String {
            return desc;
        }

    }
}