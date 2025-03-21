# Miydi Map Icons

The icons from Miydi Map Icons are seamlessly integrated with other visualizations available on this GitHub repository, enhancing the overall mapping experience. By using these customized icons, users can create more engaging and informative maps that are not only practical but visually appealing. 

These icons work particularly well with detailed datasets such as those from OpenStreetMaps, where their distinct designs help to clearly differentiate between various types of points of interest or landmark categories. Below is an example of what it looks like when these icons are applied to the OpenStreetMaps datasets within QGIS:

![Example of Icons on OpenStreetMaps](/_bin/images/qgis-bin_W876msFoVb.jpg)

This visual example illustrates how effectively the Miydi Map Icons can be employed to elevate the aesthetics and functionality of geospatial representations, making complex data easier to interpret and more accessible to a wider audience.


## Optimized Icons for Geospatial Mapping

Welcome to the Miydi Map Icons repository! Our icons, crafted with MidJourney and Adobe AI image generators, are specifically designed to enhance the visual appeal and clarity of mapping applications. Below, you'll find insights into how these icons are optimized for your mapping needs.

### Precision and Clarity

<img src="Soccer_pin_1.png" alt="Precision and Clarity" width="33%">

Our icons are engineered to provide maximum precision and clarity even at small sizes. This ensures that each icon remains distinct and readable under various mapping scenarios, helping users quickly identify important features without confusion.

### Scalability for Various Zoom Levels

<img src="food_pin_16.png" alt="Scalability" width="33%">

Scalability is key in mapping. Each icon is designed to maintain its integrity across a range of zoom levels. Whether you're viewing a citywide map or zooming into a specific neighborhood, these icons adjust beautifully, ensuring a consistent visual experience.

### Visual Consistency

<img src="Health_pin_1.png" alt="Visual Consistency" width="33%">

We've standardized the design elements across all icons to ensure visual consistency throughout your maps. This uniformity helps in maintaining an aesthetically pleasing and cohesive map interface, which is crucial for professional mapping projects.

### Enhanced Color Palette

<img src="Mountain_pin_2.png" alt="Enhanced Color Palette" width="33%">

Colors play a crucial role in mapping. Our icons come with an enhanced color palette that is not only visually engaging but also serves to differentiate between icon categories effectively. This differentiation aids users in navigating complex maps with ease.

## How to Use the Icons in QGIS

### Scale the icons based on zoom level

The default code snippet provided is used within QGIS's Expression Builder to dynamically render feature centroids with scaling based on the map scale and feature size. The map icons used for rendering are stored in the `_styles` directory, and the centroid clusters are set to a maximum display size of 80mm, ensuring that the visual representation is both informative and visually accessible across different zoom levels.

### Explanation of the Code for Feature Centroids

```plaintext
min(
    max(
        sqrt($area) / (@map_scale / 2500) * 0.2,  -- Increased scaling factor for larger size
        12  -- Increased minimum size for better visibility when zoomed in
    ),
    60  -- Slightly increased maximum size for larger appearance when zoomed out
)
```
 
# Free Mapping Resources Optimized for QGIS

The Miydi Map Icons set is a key resource for anyone seeking optimized mapping tools, freely available under the Creative Commons License. Designed with precision and compatibility in mind, these icons enhance the visual quality of maps created in QGIS and support a wide range of geospatial visualization needs. By leveraging these free resources, users can achieve professional-grade mapping results without the overhead of commercial software or proprietary restrictions.

These icons are specifically tailored to integrate smoothly with QGIS, ensuring that both novice and expert GIS users can take full advantage of their features. The inclusion of these icons as part of your mapping toolkit can significantly improve the readability and aesthetic appeal of your projects, making complex data more accessible and easier to understand.

We encourage you to utilize these icons in your various mapping endeavors and to contribute back to the community by sharing your enhancements or adaptations of the icons. Together, we can continue to expand and refine these resources, making them even more valuable to mappers everywhere.

Thank you for exploring Miydi Map Icons. Happy mapping!
