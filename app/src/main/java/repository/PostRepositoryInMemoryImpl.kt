package repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dto.Post

class PostRepositoryInMemoryImpl: PostRepository {
    private var post = Post(
        id = 1,
        textView2 = "Нетология. Университет интернет-профессий будущего",
        textView = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        textView4 = "20 февраля в 15:00",
        likedByMe = false
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
    }
    override fun share() {
        post = post.copy(shareByMe = !post.shareByMe)
        data.value = post
    }
}