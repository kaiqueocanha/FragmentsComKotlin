package com.ocanha.fragmentscomkotlin.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.ocanha.fragmentscomkotlin.repositories.PersonRepository

class MyFragmentFactory(private val personRepository: PersonRepository) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when (loadFragmentClass(classLoader, className)) {

            FragmentExample2::class.java -> {

                FragmentExample2(personRepository)

            }

            else -> {
                super.instantiate(classLoader, className)
            }

        }

    }

}