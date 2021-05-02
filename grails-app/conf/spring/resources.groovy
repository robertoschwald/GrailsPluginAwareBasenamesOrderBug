import grails.config.Config
import grails.config.Settings
import grails.util.Environment
import org.grails.spring.context.support.PluginAwareResourceBundleMessageSource

// Place your Spring DSL code here
beans = {
  Config config = application.config
  boolean gspEnableReload = config.getProperty(Settings.GSP_ENABLE_RELOAD, Boolean, false)
  String encoding = config.getProperty(Settings.GSP_VIEW_ENCODING, 'UTF-8')

  messageSource(PluginAwareResourceBundleMessageSource) {
    fallbackToSystemLocale = false
    if (Environment.current.isReloadEnabled() || gspEnableReload) {
      cacheSeconds = config.getProperty(Settings.I18N_CACHE_SECONDS, Integer, 5)
      fileCacheSeconds = config.getProperty(Settings.I18N_FILE_CACHE_SECONDS, Integer, 5)
    }
    defaultEncoding = encoding
    pluginManager = ref('pluginManager')

    /**
     * {@link org.grails.spring.context.support.ReloadableResourceBundleMessageSource#setBasenames(java.lang.String...)}
     * sais: "The associated resource bundles will be checked sequentially when resolving a message code."
     * The Spring AbstractResourceBasedMessageSource says the same, so it is expected it works that way.
     */
    basenames = [
      "frontend",
      "KbaseBundle",
    ]
  }

}
