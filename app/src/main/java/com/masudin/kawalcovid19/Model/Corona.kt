package com.masudin.kawalcovid19.Model


class Corona:ArrayList<coronaItem>()

data class coronaItem(
	val attributes: Attributes? = null
)

data class Attributes(
	val oBJECTID: Int? = null,
	val long: Int? = null,
	val recovered: Int,
	val countryRegion: String? = null,
	val active: Int? = null,
	val lastUpdate: Long? = null,
	val deaths: Int? = null,
	val confirmed: Int? = null,
	val lat: Int? = null
)

