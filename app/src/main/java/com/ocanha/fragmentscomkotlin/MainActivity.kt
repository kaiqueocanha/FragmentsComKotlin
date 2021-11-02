package com.ocanha.fragmentscomkotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.ocanha.fragmentscomkotlin.fragments.FragmentExample
import com.ocanha.fragmentscomkotlin.fragments.FragmentExample2
import com.ocanha.fragmentscomkotlin.fragments.MyFragmentFactory
import com.ocanha.fragmentscomkotlin.repositories.PersonRepository

class MainActivity : AppCompatActivity() {

    private val personRepository: PersonRepository = PersonRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.fragmentFactory = MyFragmentFactory(personRepository)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            callFragmentExample()
        }

        setupUi()

    }

    private fun setupUi() {

        findViewById<Button>(R.id.btnFragment1).setOnClickListener {

            callFragmentExample()

        }

        findViewById<Button>(R.id.btnFragment2).setOnClickListener {

            callFragmentExample2()

        }

    }

    private fun callFragmentExample2() {

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentExample2>(R.id.fragment_container_view)
        }

    }

    private fun callFragmentExample() {

//        val bundle = bundleOf(
//            "USER_AGE" to 25,
//            "USER_NAME" to "Kaique Ocanha"
//        )

        val bundleWithObject = bundleOf(
            "PERSON" to Person("Kaique Ocanha", 25)
        )

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentExample>(R.id.fragment_container_view, args = bundleWithObject)
        }

    }

}