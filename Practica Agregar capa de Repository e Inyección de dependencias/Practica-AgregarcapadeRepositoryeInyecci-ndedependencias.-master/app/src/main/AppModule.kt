@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMarsRepository(apiService: MarsApiService): MarsRepository {
        return MarsRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideMarsApiService(): MarsApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/mars-photos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarsApiService::class.java)
    }
}
