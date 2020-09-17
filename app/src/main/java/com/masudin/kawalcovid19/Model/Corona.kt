package com.masudin.kawalcovid19.Model


class Corona:ArrayList<coronaItem>()

data class coronaItem(
	val attributes: Attributes
)

data class Attributes(
	val oBJECTID: Int,
	val long: Int,
	val recovered: Int,
	val countryRegion: String,
	val active: Int,
	val lastUpdate: Long,
	val deaths: Int,
	val confirmed: Int,
	val lat: Int
)

