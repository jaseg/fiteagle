//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.16 at 10:17:53 AM CEST 
//


package org.fiteagle.interactors.sfa.rspec.advertisement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.fiteagle.interactors.sfa.rspec.ext.Method;
import org.fiteagle.interactors.sfa.rspec.ext.Parameter;
import org.fiteagle.interactors.sfa.rspec.ext.Property;
import org.fiteagle.interactors.sfa.rspec.ext.Resource;
import org.fiteagle.interactors.sfa.rspec.ext.openstack.Flavor;
import org.fiteagle.interactors.sfa.rspec.ext.openstack.Flavors;
import org.fiteagle.interactors.sfa.rspec.ext.openstack.Image;
import org.fiteagle.interactors.sfa.rspec.ext.openstack.OpenstackResource;
import org.fiteagle.interactors.sfa.rspec.ext.openstack.Vm;
import org.fiteagle.interactors.sfa.rspec.ext.openstack.VmToInstantiate;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.geni.resources.rspec._3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NodeContentsSliverTypeDiskImage_QNAME = new QName("http://www.geni.net/resources/rspec/3", "disk_image");
    private final static QName _ExternalRef_QNAME = new QName("http://www.geni.net/resources/rspec/3", "external_ref");
    private final static QName _InterfaceRef_QNAME = new QName("http://www.geni.net/resources/rspec/3", "interface_ref");
    private final static QName _Login_QNAME = new QName("http://www.geni.net/resources/rspec/3", "login");
    private final static QName _TypeRelation_QNAME = new QName("http://www.geni.net/resources/rspec/3", "type_relation");
    private final static QName _Rspec_QNAME = new QName("http://www.geni.net/resources/rspec/3", "rspec");
    private final static QName _Node_QNAME = new QName("http://www.geni.net/resources/rspec/3", "node");
    private final static QName _Ip_QNAME = new QName("http://www.geni.net/resources/rspec/3", "ip");
    private final static QName _Interface_QNAME = new QName("http://www.geni.net/resources/rspec/3", "interface");
    private final static QName _Available_QNAME = new QName("http://www.geni.net/resources/rspec/3", "available");
    private final static QName _Property_QNAME = new QName("http://www.geni.net/resources/rspec/3", "property");
    private final static QName _Relation_QNAME = new QName("http://www.geni.net/resources/rspec/3", "relation");
    private final static QName _Link_QNAME = new QName("http://www.geni.net/resources/rspec/3", "link");
    private final static QName _HardwareType_QNAME = new QName("http://www.geni.net/resources/rspec/3", "hardware_type");
    private final static QName _Location_QNAME = new QName("http://www.geni.net/resources/rspec/3", "location");
    private final static QName _Monitoring_QNAME = new QName("http://www.geni.net/resources/rspec/3", "monitoring");
    private final static QName _Execute_QNAME = new QName("http://www.geni.net/resources/rspec/3", "execute");
    private final static QName _Services_QNAME = new QName("http://www.geni.net/resources/rspec/3", "services");
    private final static QName _Install_QNAME = new QName("http://www.geni.net/resources/rspec/3", "install");
    private final static QName _NodeContentsSliverType_QNAME = new QName("http://www.geni.net/resources/rspec/3", "sliver_type");

    
//    //Additional QNames for FITeagle resource description
////    private final static QName _Resource_QNAME = new QName("http://www.fiteagle.org/rspec/ext/1", "resource");
////    private final static QName _Property_QNAME_FITEAGLE = new QName("http://www.fiteagle.org/rspec/ext/1", "property");
////    private final static QName _Method_QNAME = new QName("http://www.fiteagle.org/rspec/ext/1", "method");
////    private final static QName _Parameter_QNAME = new QName("http://www.fiteagle.org/rspec/ext/1", "parameter");
//    private final static QName _Property_QNAME_FITEAGLE = new QName("http://fiteagle.org/rspec/ext/1", "property");
//    private final static QName _Method_QNAME = new QName("http://fiteagle.org/rspec/ext/1", "method");
//    private final static QName _Resource_QNAME = new QName("http://fiteagle.org/rspec/ext/1", "resource");
//    private final static QName _Parameter_QNAME = new QName("http://fiteagle.org/rspec/ext/1", "parameter");
//    
//    
//    
//  //Additional QNames for Openstack resource description
//    private final static QName _Vm_QNAME = new QName("http://fiteagle.org/rspec/ext/1/openstackVMResource", "vm");
//    private final static QName _VmToInstantiate_QNAME = new QName("http://fiteagle.org/rspec/ext/1/openstackVMResource", "vmToInstantiate");
//    private final static QName _OpenstackResource_QNAME = new QName("http://fiteagle.org/rspec/ext/1/openstackVMResource", "openstackResource");
//    private final static QName _Flavors_QNAME = new QName("http://fiteagle.org/rspec/ext/1/openstackVMResource", "flavors");
//    private final static QName _Image_QNAME = new QName("http://fiteagle.org/rspec/ext/1/openstackVMResource", "image");
//    private final static QName _Flavor_QNAME = new QName("http://fiteagle.org/rspec/ext/1/openstackVMResource", "flavor");
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.geni.resources.rspec._3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TypeRelationContents }
     * 
     */
    public TypeRelationContents createTypeRelationContents() {
        return new TypeRelationContents();
    }

    /**
     * Create an instance of {@link NodeContents }
     * 
     */
    public NodeContents createNodeContents() {
        return new NodeContents();
    }

    /**
     * Create an instance of {@link NodeContents.SliverType }
     * 
     */
    public NodeContents.SliverType createNodeContentsSliverType() {
        return new NodeContents.SliverType();
    }

    /**
     * Create an instance of {@link InstallServiceContents }
     * 
     */
    public InstallServiceContents createInstallServiceContents() {
        return new InstallServiceContents();
    }

    /**
     * Create an instance of {@link ExecuteServiceContents }
     * 
     */
    public ExecuteServiceContents createExecuteServiceContents() {
        return new ExecuteServiceContents();
    }

    /**
     * Create an instance of {@link ServiceContents }
     * 
     */
    public ServiceContents createServiceContents() {
        return new ServiceContents();
    }

    /**
     * Create an instance of {@link MonitoringContents }
     * 
     */
    public MonitoringContents createMonitoringContents() {
        return new MonitoringContents();
    }

    /**
     * Create an instance of {@link HardwareTypeContents }
     * 
     */
    public HardwareTypeContents createHardwareTypeContents() {
        return new HardwareTypeContents();
    }

    /**
     * Create an instance of {@link LocationContents }
     * 
     */
    public LocationContents createLocationContents() {
        return new LocationContents();
    }

    /**
     * Create an instance of {@link LinkContents }
     * 
     */
    public LinkContents createLinkContents() {
        return new LinkContents();
    }

    /**
     * Create an instance of {@link RelationContents }
     * 
     */
    public RelationContents createRelationContents() {
        return new RelationContents();
    }

    /**
     * Create an instance of {@link LinkPropertyContents }
     * 
     */
    public LinkPropertyContents createLinkPropertyContents() {
        return new LinkPropertyContents();
    }

    /**
     * Create an instance of {@link AvailableContents }
     * 
     */
    public AvailableContents createAvailableContents() {
        return new AvailableContents();
    }

    /**
     * Create an instance of {@link InterfaceContents }
     * 
     */
    public InterfaceContents createInterfaceContents() {
        return new InterfaceContents();
    }

    /**
     * Create an instance of {@link IpContents }
     * 
     */
    public IpContents createIpContents() {
        return new IpContents();
    }

    /**
     * Create an instance of {@link RSpecContents }
     * 
     */
    public RSpecContents createRSpecContents() {
        return new RSpecContents();
    }

    /**
     * Create an instance of {@link ComponentManager }
     * 
     */
    public ComponentManager createComponentManager() {
        return new ComponentManager();
    }

    /**
     * Create an instance of {@link Cloud }
     * 
     */
    public Cloud createCloud() {
        return new Cloud();
    }

    /**
     * Create an instance of {@link LoginServiceContents }
     * 
     */
    public LoginServiceContents createLoginServiceContents() {
        return new LoginServiceContents();
    }

    /**
     * Create an instance of {@link LinkClass }
     * 
     */
    public LinkClass createLinkClass() {
        return new LinkClass();
    }

    /**
     * Create an instance of {@link InterfaceRefContents }
     * 
     */
    public InterfaceRefContents createInterfaceRefContents() {
        return new InterfaceRefContents();
    }

    /**
     * Create an instance of {@link LinkType }
     * 
     */
    public LinkType createLinkType() {
        return new LinkType();
    }

    /**
     * Create an instance of {@link ExternalReferenceContents }
     * 
     */
    public ExternalReferenceContents createExternalReferenceContents() {
        return new ExternalReferenceContents();
    }

    /**
     * Create an instance of {@link DiskImageContents }
     * 
     */
    public DiskImageContents createDiskImageContents() {
        return new DiskImageContents();
    }

    /**
     * Create an instance of {@link TypeRelationContents.SliverType }
     * 
     */
    public TypeRelationContents.SliverType createTypeRelationContentsSliverType() {
        return new TypeRelationContents.SliverType();
    }

    /**
     * Create an instance of {@link NodeContents.SliverType.DiskImage }
     * 
     */
    public NodeContents.SliverType.DiskImage createNodeContentsSliverTypeDiskImage() {
        return new NodeContents.SliverType.DiskImage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeContents.SliverType.DiskImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "disk_image", scope = NodeContents.SliverType.class)
    public JAXBElement<NodeContents.SliverType.DiskImage> createNodeContentsSliverTypeDiskImage(NodeContents.SliverType.DiskImage value) {
        return new JAXBElement<NodeContents.SliverType.DiskImage>(_NodeContentsSliverTypeDiskImage_QNAME, NodeContents.SliverType.DiskImage.class, NodeContents.SliverType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalReferenceContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "external_ref")
    public JAXBElement<ExternalReferenceContents> createExternalRef(ExternalReferenceContents value) {
        return new JAXBElement<ExternalReferenceContents>(_ExternalRef_QNAME, ExternalReferenceContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterfaceRefContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "interface_ref")
    public JAXBElement<InterfaceRefContents> createInterfaceRef(InterfaceRefContents value) {
        return new JAXBElement<InterfaceRefContents>(_InterfaceRef_QNAME, InterfaceRefContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginServiceContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "login")
    public JAXBElement<LoginServiceContents> createLogin(LoginServiceContents value) {
        return new JAXBElement<LoginServiceContents>(_Login_QNAME, LoginServiceContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TypeRelationContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "type_relation")
    public JAXBElement<TypeRelationContents> createTypeRelation(TypeRelationContents value) {
        return new JAXBElement<TypeRelationContents>(_TypeRelation_QNAME, TypeRelationContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RSpecContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "rspec")
    public JAXBElement<RSpecContents> createRspec(RSpecContents value) {
        return new JAXBElement<RSpecContents>(_Rspec_QNAME, RSpecContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "node")
    public JAXBElement<NodeContents> createNode(NodeContents value) {
        return new JAXBElement<NodeContents>(_Node_QNAME, NodeContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IpContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "ip")
    public JAXBElement<IpContents> createIp(IpContents value) {
        return new JAXBElement<IpContents>(_Ip_QNAME, IpContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterfaceContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "interface")
    public JAXBElement<InterfaceContents> createInterface(InterfaceContents value) {
        return new JAXBElement<InterfaceContents>(_Interface_QNAME, InterfaceContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvailableContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "available")
    public JAXBElement<AvailableContents> createAvailable(AvailableContents value) {
        return new JAXBElement<AvailableContents>(_Available_QNAME, AvailableContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkPropertyContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "property")
    public JAXBElement<LinkPropertyContents> createProperty(LinkPropertyContents value) {
        return new JAXBElement<LinkPropertyContents>(_Property_QNAME, LinkPropertyContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelationContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "relation")
    public JAXBElement<RelationContents> createRelation(RelationContents value) {
        return new JAXBElement<RelationContents>(_Relation_QNAME, RelationContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "link")
    public JAXBElement<LinkContents> createLink(LinkContents value) {
        return new JAXBElement<LinkContents>(_Link_QNAME, LinkContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HardwareTypeContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "hardware_type")
    public JAXBElement<HardwareTypeContents> createHardwareType(HardwareTypeContents value) {
        return new JAXBElement<HardwareTypeContents>(_HardwareType_QNAME, HardwareTypeContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "location")
    public JAXBElement<LocationContents> createLocation(LocationContents value) {
        return new JAXBElement<LocationContents>(_Location_QNAME, LocationContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MonitoringContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "monitoring")
    public JAXBElement<MonitoringContents> createMonitoring(MonitoringContents value) {
        return new JAXBElement<MonitoringContents>(_Monitoring_QNAME, MonitoringContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteServiceContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "execute")
    public JAXBElement<ExecuteServiceContents> createExecute(ExecuteServiceContents value) {
        return new JAXBElement<ExecuteServiceContents>(_Execute_QNAME, ExecuteServiceContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "services")
    public JAXBElement<ServiceContents> createServices(ServiceContents value) {
        return new JAXBElement<ServiceContents>(_Services_QNAME, ServiceContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InstallServiceContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "install")
    public JAXBElement<InstallServiceContents> createInstall(InstallServiceContents value) {
        return new JAXBElement<InstallServiceContents>(_Install_QNAME, InstallServiceContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeContents.SliverType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "sliver_type", scope = NodeContents.class)
    public JAXBElement<NodeContents.SliverType> createNodeContentsSliverType(NodeContents.SliverType value) {
        return new JAXBElement<NodeContents.SliverType>(_NodeContentsSliverType_QNAME, NodeContents.SliverType.class, NodeContents.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TypeRelationContents.SliverType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "sliver_type", scope = TypeRelationContents.class)
    public JAXBElement<TypeRelationContents.SliverType> createTypeRelationContentsSliverType(TypeRelationContents.SliverType value) {
        return new JAXBElement<TypeRelationContents.SliverType>(_NodeContentsSliverType_QNAME, TypeRelationContents.SliverType.class, TypeRelationContents.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiskImageContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.geni.net/resources/rspec/3", name = "disk_image", scope = TypeRelationContents.class)
    public JAXBElement<DiskImageContents> createTypeRelationContentsDiskImage(DiskImageContents value) {
        return new JAXBElement<DiskImageContents>(_NodeContentsSliverTypeDiskImage_QNAME, DiskImageContents.class, TypeRelationContents.class, value);
    }
    
    
//    //FITeagle specific resource description!!!!!!!!!!!!!!!!!!!!
//    /**
//     * Create an instance of {@link Parameter }
//     * 
//     */
//    public Parameter createParameter() {
//        return new Parameter();
//    }
//
//    /**
//     * Create an instance of {@link Resource }
//     * 
//     */
//    public Resource createResource() {
//        return new Resource();
//    }
//
//    /**
//     * Create an instance of {@link Method }
//     * 
//     */
//    public Method createMethod() {
//        return new Method();
//    }
//
//    /**
//     * Create an instance of {@link Property }
//     * 
//     */
//    public Property createProperty() {
//        return new Property();
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Property }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1", name = "property")
//    public JAXBElement<Property> createProperty(Property value) {
//        return new JAXBElement<Property>(_Property_QNAME_FITEAGLE, Property.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Method }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1", name = "method")
//    public JAXBElement<Method> createMethod(Method value) {
//        return new JAXBElement<Method>(_Method_QNAME, Method.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Resource }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1", name = "resource")
//    public JAXBElement<Resource> createResource(Resource value) {
//        return new JAXBElement<Resource>(_Resource_QNAME, Resource.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Parameter }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1", name = "parameter")
//    public JAXBElement<Parameter> createParameter(Parameter value) {
//        return new JAXBElement<Parameter>(_Parameter_QNAME, Parameter.class, null, value);
//    }
//    
//    
//    //Openstack specific resource description!!!!!!!!!!!!!!!!!!!!
//    
//    /**
//     * Create an instance of {@link VmToInstantiate }
//     * 
//     */
//    public VmToInstantiate createVmToInstantiate() {
//        return new VmToInstantiate();
//    }
//
//    /**
//     * Create an instance of {@link Vm }
//     * 
//     */
//    public Vm createVm() {
//        return new Vm();
//    }
//
//    /**
//     * Create an instance of {@link Flavor }
//     * 
//     */
//    public Flavor createFlavor() {
//        return new Flavor();
//    }
//
//    /**
//     * Create an instance of {@link Image }
//     * 
//     */
//    public Image createImage() {
//        return new Image();
//    }
//
//    /**
//     * Create an instance of {@link Flavors }
//     * 
//     */
//    public Flavors createFlavors() {
//        return new Flavors();
//    }
//
//    /**
//     * Create an instance of {@link OpenstackResource }
//     * 
//     */
//    public OpenstackResource createOpenstackResource() {
//        return new OpenstackResource();
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Vm }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1/openstackVMResource", name = "vm")
//    public JAXBElement<Vm> createVm(Vm value) {
//        return new JAXBElement<Vm>(_Vm_QNAME, Vm.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link VmToInstantiate }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1/openstackVMResource", name = "vmToInstantiate")
//    public JAXBElement<VmToInstantiate> createVmToInstantiate(VmToInstantiate value) {
//        return new JAXBElement<VmToInstantiate>(_VmToInstantiate_QNAME, VmToInstantiate.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link OpenstackResource }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1/openstackVMResource", name = "openstackResource")
//    public JAXBElement<OpenstackResource> createOpenstackResource(OpenstackResource value) {
//        return new JAXBElement<OpenstackResource>(_OpenstackResource_QNAME, OpenstackResource.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Flavors }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1/openstackVMResource", name = "flavors")
//    public JAXBElement<Flavors> createFlavors(Flavors value) {
//        return new JAXBElement<Flavors>(_Flavors_QNAME, Flavors.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Image }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1/openstackVMResource", name = "image")
//    public JAXBElement<Image> createImage(Image value) {
//        return new JAXBElement<Image>(_Image_QNAME, Image.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Flavor }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "http://fiteagle.org/rspec/ext/1/openstackVMResource", name = "flavor")
//    public JAXBElement<Flavor> createFlavor(Flavor value) {
//        return new JAXBElement<Flavor>(_Flavor_QNAME, Flavor.class, null, value);
//    }
    

    

}
