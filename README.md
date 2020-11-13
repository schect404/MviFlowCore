# MviFlowCore
Library with basic components to implement MVI + Flow. Usage sample could be found in https://github.com/schect404/SampleFilters

**Dependencies**

- kotlinx-coroutines-core
- kotlinx-coroutines-android
- lifecycle-viewmodel-ktx
- lifecycle-runtime-ktx
- xyz.peridy.shimmer:shimmerlayout https://github.com/rnpy/ShimmerLayout
- LastAdapter https://github.com/nitrico/LastAdapter
- Glide https://github.com/bumptech/glide
- Chuck Interceptor https://github.com/jgilfelt/chuck

**Scheme**

![MVI scheme](https://github.com/schect404/MviFlowCore/blob/main/scheme.png)

**Base Components**

- interface BaseViewIntent - intent from view to model
- interface BaseModelIntent - single intent from model to view
- interface BaseViewState - marker for ViewState
- interface BasePartialChange<T: BaseViewState> - reduces intent result to ViewState changes
- abstract class BaseFragment<VI : BaseViewIntent,
        SI : BaseModelIntent, S : BaseViewState,
        PC: BasePartialChange> - fragment to extend
- abstract class BaseActor<VI : BaseViewIntent,
                           SI : BaseModelIntent,
                           S : BaseViewState,
                           PC : BasePartialChange> - ViewModel aka handler of intents
- abstract class BaseNavigator(@IdRes private val idContainer: Int) - navigator with id of the container in which animation should go
- interface BaseContract - marker for contracts, in contract should be defined ViewIntent, ModelIntent, ViewState, PartialChange
- AsyncObservableList - list wrapper for lists with databinding using LastAdapter

**Stub Components**

Could be used when at least anything from the above list is not needed

- class StubViewIntent : BaseViewIntent
- class StubModelIntent : BaseModelIntent
- class StubViewState : BaseViewState
- class StubPartialChange : BasePartialChange<StubViewState>
- class StubActor : BaseActor<StubViewIntent, StubModelIntent, StubViewState, StubPartialChange>()
- abstract class SimpleFragment : BaseFragment<StubViewIntent, StubModelIntent, StubViewState, StubPartialChange>()
  
**Useful extensions**

- fun View.clicks(): Flow\<View>
- fun SwipeRefreshLayout.refreshes(): Flow\<Unit>
- fun CheckBox.checkChanges(): Flow\<Boolean>
- fun EditText.textChanges(): Flow\<String>  
- fun ViewPager2.pageChanges(): Flow\<Int>  
- fun \<A, B, R> Flow\<A>.withLatestFrom(other: Flow\<B>, transform: suspend (A, B) -> R): Flow\<R>
 <br></br>
- fun View.visible()
- fun View.gone()
- fun View.invisible()
- fun View.visibleIfOrGone(predicate: () -> Boolean)
- fun View.visibleIfOrInvisible(predicate: () -> Boolean)
- fun View.disable()
- fun fun View.enable()
- fun View.enableIf(predicate: () -> Boolean)
- fun RecyclerView.attachAdapter(listAdapter: RecyclerView.Adapter<*>)
- fun ImageView.image(url: String?, @DrawableRes placeholder: Int? = null, shouldGoneIfError: Boolean = false)

**Functions to be overriden in Actor**

***Required properties***

- protected abstract val initialState: S

***Optional functions***

> This function proceeds from ViewIntent to PartialChange(here you can do requests etc.), in PartialChange you have to override reducer from change to ViewState
- open fun Flow<VI>.handleIntent(): Flow<PC>

> This function proceeds from PartialChange to SingleEvent(ModelIntent) if needed. If not, just return null
- open fun PC.getSingleEvent(): SI?

> This function maps error in flow from Throwable to String and emits it to Fragment's handleError(error: String) is using run functions, you should make your own MyBaseActor and implement it there
- protected open fun transformError(error: Throwable): String?

***Useful extensions***

> Those functions are for asynchronous calls like requests to api
- protected fun <T> Flow<T>.runWithProgress(rethrowError: Boolean = false)
- protected fun <T> Flow<T>.runWithoutProgress(rethrowError: Boolean = false)  

**Functions to be overriden in Fragment**

***Required properties***

- abstract val actor: BaseActor\<VI, SI, S, PC>
- abstract val navigator: BaseNavigator
- abstract val layoutRes: Int

***Optional functions***

> These two functions should be overriden in your BaseFragment in order to rearrange error handling and progress
- open fun handleError(error: String)
- open fun handleProgress(isProgressFlowing: Boolean)
<br></br>
> This function defines scope of intents registered to flow from view to model
- open fun intents(): Flow\<VI>?
<br></br>
> This function defines behaviour of rendering the viewstate
- open fun render(state: S) {}
<br></br>
> This function defines behaviour depending on received model intents
- open fun handleSingleEvent(event: SI) {}





  
