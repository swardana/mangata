# Mangata and Scene Builder Support

For using Mangata library with Scene Builder, please use `mangata-all` jar file. 
Mangata library is consist of `mangata-base` and `mangata` specific icon font. 
This architecture not playing well with Scene Builder.

The `mangata-all` is an uber jar that bundles all the Mangata libraries. 
Including the `mangata-base` and all available `mangata` specific icon font.

Available in the [Maven Central Repository](https://search.maven.org/search?q=g:com.swardana.mangata%20AND%20a:mangata-all)

To add `mangata-all` into Scene Builder, please refer to [Scene Builder Docs](https://docs.gluonhq.com/scenebuilder/#_library_manager).

Note:
The `mangata-all` dependency purpose is for Scene Builder integration only. 
When you already have the FXML file and put it in your project you don't 
need it anymore. You can use the `mangata` specific font icon in your project. 