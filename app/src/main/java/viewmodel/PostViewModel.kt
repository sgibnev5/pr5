package viewmodel

import androidx.lifecycle.ViewModel
import repository.PostRepository
import repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
}