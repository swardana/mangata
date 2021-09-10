# Documentation of Mangata Metro

Mangata Metro is a JavaFX UI Control for Metro UI Icon Font.
Mangata Metro is part of Mangata project.

## Installation

Release 1.0.0 is the current latest release. This release is consider stable and
worthy of the 1.x tag. It support Java Platform Module System (JPMS) with
module name `com.swardana.mangata.metro`.

Available in the [Maven Central Repository](https://search.maven.org/search?q=g:com.swardana.mangata%20AND%20a:mangata-metro)

### Maven Configuration

```xml
<dependency>
  <groupId>com.swardana.mangata</groupId>
  <artifactId>mangata-metro</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle Configuration

```groovy
implementation 'com.swardana.mangata:mangata-metro:1.0.0'
```

## Usage

### Sample usage using Java code.

```java
import com.swardana.mangata.metro.MetroIconFont;
import com.swardana.mangata.metro.MetroIcon;
import javafx.scene.paint.Color;

MetroIcon openFolderIcon = new MetroIcon(MetroIconFont.FOLDER_OPEN, 12, Color.GRAY);
```

### Sample usage using FXML code.

```xml
<?import com.swardana.mangata.metro.MetroIcon?>

<MetroIcon color="#900505" content="FOLDER_OPEN" size="32" />
```

### Sample usage styling icon using css class.

* `style.css`
```css
.ico {
  -fx-icon-size: 32;
  -fx-icon-color: red;
}
```

* `App.java`
```java
import com.swardana.mangata.metro.MetroIconFont;
import com.swardana.mangata.metro.MetroIcon;
import javafx.scene.paint.Color;

MetroIcon openFolderIcon = new MetroIcon(MetroIconFont.FOLDER_OPEN, 12, Color.GRAY);
openFolderIcon.getStyleClass().add("ico");
```

Set the style class will overriding the constructor argument when creating the
icon. Currently, only support either declare all the constructor argument or
leave it as empty.