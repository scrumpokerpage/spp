package com.scrumpokerpage.spp

import com.scrumpokerpage.spp.domain.MasterDatabaseCreator
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@EnableAutoConfiguration
@ComponentScan(
	basePackages = ["com.scrumpokerpage.spp"],
	excludeFilters = [
		ComponentScan.Filter(
			type = FilterType.ASSIGNABLE_TYPE,
			classes = [ MasterDatabaseCreator::class ]
		)
	]
)
class SppApplication

fun main(args: Array<String>) {
	runApplication<SppApplication>(*args)
}
