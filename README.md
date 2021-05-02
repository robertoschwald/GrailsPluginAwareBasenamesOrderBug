# Example Grails Project showing basenames order problem

In this example, messagSource bean definition is set in resources.groovy with an array of basenames to use.
```
 basenames = [
      "frontend",
      "KbaseBundle",
    ]
```

PluginAwareResourceBundleMessageSource does not respect the order and orders like this:

```
0 = KbaseBundle
1 = frontend
```




