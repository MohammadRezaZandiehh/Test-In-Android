package com.example.writetestinandroid

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before

import org.junit.Test

class ResourceComparerTest {

/*The best way:*/
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()               // yani ghable har @Test bia inaro anjam bede
    }
/**
 *  ye @After ham darim k yani bade inke karesh anjam shod bia ye jooraei mese Garbage collector amal kon
 * va inaro az beyn bebar ----> b khosos dar Room k sangine khili b kar miad.*/

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "WriteTestInAndroid")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDeffrentAsGivenString_returnsFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Hello")
        assertThat(result).isFalse()
    }



    /*The better way:*/
    /**
     * in rah baz behtare k har instance jodagane dar har method seda zade she
     * vali baz ye badi dare inke fek kon 30 ta method dashtim onvaght bayad 30 bar in khat ro mineveshtim k khob
     * behine nis.
     * */
/*    private lateinit var resourceComparer: ResourceComparer

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        resourceComparer = ResourceComparer()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "WriteTestInAndroid")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDeffrentAsGivenString_returnsFalse(){
        resourceComparer = ResourceComparer()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Hello")
        assertThat(result).isFalse()
    }*/


    /*The worst way:*/
    /**
     * is rahe avali hast vase test neveshtan ama bayad bedoonim k rahe khili khobi nis vase inke
     * yeki az sharayete khoob bodane test in hast k test hamoon b ham vabaste nabashan va ya
     * nabayad falke beshan yani ye bar success bashan ye bar failure.
     *
     * dar in halat mibinim k joft e method haye zir resourceComparer ro daran va in khob nis*/

/*    val resourceComparer = ResourceComparer()

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "WriteTestInAndroid")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDeffrentAsGivenString_returnsFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Hello")
        assertThat(result).isFalse()
    }*/
}