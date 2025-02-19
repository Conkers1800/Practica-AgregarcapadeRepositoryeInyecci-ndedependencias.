package com.example.marsphotos

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marsphotos.data.MarsRepository
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.android.testing.InjectMock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import androidx.test.rule.GrantPermissionRule
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@Config(application = HiltTestApplication::class)
@OptIn(ExperimentalCoroutinesApi::class)
class NetworkMarsRepositoryTest {

    @get:Rule
    var hiltRule = dagger.hilt.android.testing.HiltAndroidRule(this)

    @Inject
    lateinit var repository: MarsRepository

    @Before
    fun setup() {
        hiltRule.inject() // Inyecta el repositorio usando Hilt
    }

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest {
        val photos = repository.getMarsPhotos()
        assertEquals(photos.isNotEmpty(), true) // Verifica que la lista no está vacía
    }
}
